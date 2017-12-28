/**
  * -------------------------------------------------------------------------
  * (C) Copyright Gyyx Tec Corp. 1996-2017 - All Rights Reserved
  * @版权所有：北京光宇在线科技有限责任公司
  * @项目名称：mutexkey
  * @作者：niushuai
  * @联系方式：niushuai@gyyx.cn
  * @创建时间：2017年12月28日 下午4:11:09
  * @版本号：0.0.1
  *-------------------------------------------------------------------------
  */
package mutexkey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * DataService描述
 * </p>
 * 
 * @author niushuai
 * @since 0.0.1
 */
public class DataService {

    private Logger log = LoggerFactory.getLogger(DataService.class);

    public String getData() {
        log.info("DataService.getData，当前线程：{}", Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("线程{}休息失败", Thread.currentThread().getId());
        }
        return "data";
    }
}
