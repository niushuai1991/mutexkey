/**
  * -------------------------------------------------------------------------
  * (C) Copyright Gyyx Tec Corp. 1996-2017 - All Rights Reserved
  * @版权所有：北京光宇在线科技有限责任公司
  * @项目名称：mutexkey
  * @作者：niushuai
  * @联系方式：niushuai@gyyx.cn
  * @创建时间：2017年12月28日 下午4:17:13
  * @版本号：0.0.1
  *-------------------------------------------------------------------------
  */
package mutexkey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * JobThread描述
 * </p>
 * 
 * @author niushuai
 * @since 0.0.1
 */
public class JobThread extends Thread {

    private Logger log = LoggerFactory.getLogger(JobThread.class);
    private String data;
    private CacheTool cacheTool;

    public JobThread(CacheTool cacheTool) {
        this.cacheTool = cacheTool;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        data = new MutexKeyTool(cacheTool) {
            @Override
            public String loadData() {
                return new DataService().getData();
            }
        }.getData("1");
        long end = System.currentTimeMillis();
        log.info("耗时：{},线程id:{}, data:{}", end - start,
            Thread.currentThread().getName(), data);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}