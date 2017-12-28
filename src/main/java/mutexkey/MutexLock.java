/**
  * -------------------------------------------------------------------------
  * (C) Copyright Gyyx Stringec Corp. 1996-2017 - All Rights Reserved
  * @版权所有：北京光宇在线科技有限责任公司
  * @项目名称：mutexkey
  * @作者：niushuai
  * @联系方式：niushuai@gyyx.cn
  * @创建时间：2017年12月28日 下午4:58:10
  * @版本号：0.0.1
  *-------------------------------------------------------------------------
  */
package mutexkey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 互斥锁工具类
 * </p>
 * 
 * @author niushuai
 * @since 0.0.1
 */
public abstract class MutexLock {

    private Logger log = LoggerFactory.getLogger(MutexLock.class);
    private CacheTool cacheTool;

    public MutexLock(CacheTool cacheTool) {
        this.cacheTool = cacheTool;
    }

    /**
     * <p>
     * mutex
     * </p>
     *
     * 
     * niushuai 2017年12月28日 下午5:24:32 描述
     *
     * @param key
     * @return String 缓存数据
     */
    public String getData(String key) {
        String mutexKey = key + "_mutex";
        String data = null;
        for (int i = 0; i < 1000; i++) {
            data = cacheTool.get(key);
            // 如果有缓存数据
            if (data != null) {
                log.info("通过缓存获取到数据！");
                break;
            }
            // 尝试添加互斥锁
            if (cacheTool.add(mutexKey, "")) {
                // 如果有缓存数据
                data = cacheTool.get(key);
                // 如果有缓存数据
                if (data != null) {
                    log.info("通过缓存获取到数据！");
                    break;
                }
                // 没有缓存，调用loadData()
                data = loadData();
                // 添加到缓存中
                cacheTool.set(key, data);
                // 删除互斥锁
                cacheTool.delete(mutexKey);
                break;
            } else {
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    log.info("线程休眠失败。");
                }
            }
        }
        if (data == null) {
            data = loadData();
        }
        return data;
    }

    /**
     * <p>
     * 该方法从实际的方法中去获取数据
     * </p>
     *
     * 
     * niushuai 2017年12月28日 下午5:24:12 描述
     *
     * @return String 要缓存的数据
     */
    public abstract String loadData();

}
