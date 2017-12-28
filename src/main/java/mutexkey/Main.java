/**
  * -------------------------------------------------------------------------
  * (C) Copyright Gyyx Tec Corp. 1996-2017 - All Rights Reserved
  * @版权所有：北京光宇在线科技有限责任公司
  * @项目名称：mutexkey
  * @作者：niushuai
  * @联系方式：niushuai@gyyx.cn
  * @创建时间：2017年12月28日 下午3:23:10
  * @版本号：0.0.1
  *-------------------------------------------------------------------------
  */
package mutexkey;

/**
 * <p>
 * Main描述
 * </p>
 * 
 * @author niushuai
 * @since 0.0.1
 */
public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        CacheTool cacheTool = new CacheTool();
        for (int x = 0; x < 10; x++) {
            for (int i = 0; i < 100; i++) {
                JobThread job = new JobThread(cacheTool);
                job.start();
            }
            try {
                // 1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
