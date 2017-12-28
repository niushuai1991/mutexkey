/**
  * -------------------------------------------------------------------------
  * (C) Copyright Gyyx Stringec Corp. 1996-2017 - All Rights Reserved
  * @版权所有：北京光宇在线科技有限责任公司
  * @项目名称：mutexkey
  * @作者：niushuai
  * @联系方式：niushuai@gyyx.cn
  * @创建时间：2017年12月28日 下午3:38:40
  * @版本号：0.0.1
  *-------------------------------------------------------------------------
  */
package mutexkey;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * CacheStringool描述
 * </p>
 * 
 * @author niushuai
 * @since 0.0.1
 */
public class CacheTool {

    private Map<String, String> map = new ConcurrentHashMap<String, String>();

    public boolean add(String key, String value) {
        return map.putIfAbsent(key, value) == null;
    }

    public void set(String key, String value) {
        map.put(key, value);
    }

    public String get(String key) {
        return map.get(key);
    }

    /**
     * <p>
     * 删除key
     * </p>
     *
     * 
     * niushuai 2017年12月28日 下午5:05:45 描述
     *
     * @param key
     *            void
     */
    public void delete(String key) {
        map.remove(key);
    }
}
