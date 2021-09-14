package cn.disscode.app.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 示例（定时任务）
 *
 * @Author: dumplingBao
 * @Date: 2021/9/14
 */
@Component
@Slf4j
public class ScheduledTasks {

    /**
     * @Scheduled 参数
     * （1）cron：cron表达式，指定任务在特定时间执行；
     *     （2）fixedDelay：表示上一次任务执行完成后多久再次执行，参数类型为long，单位ms；
     *     （3）fixedDelayString：与fixedDelay含义一样，只是参数类型变为String；
     *     （4）fixedRate：表示按一定的频率执行任务，参数类型为long，单位ms；
     *     （5）fixedRateString: 与fixedRate的含义一样，只是将参数类型变为String；
     *     （6）initialDelay：表示延迟多久再第一次执行任务，参数类型为long，单位ms；
     *     （7）initialDelayString：与initialDelay的含义一样，只是将参数类型变为String；
     *     （8）zone：时区，默认为当前时区，一般没有用到。
     */

    /**
     * cron表达式 字符含义
     * 秒：可出现", - * /"四个字符，有效范围为0-59的整数
     * 分：可出现", - * /"四个字符，有效范围为0-59的整数
     * 时：可出现", - * /"四个字符，有效范围为0-23的整数
     * 每月第几天：可出现", - * / ? L W C"八个字符，有效范围为0-31的整数
     * 月：可出现", - * /"四个字符，有效范围为1-12的整数或JAN-DEc
     * 星期：可出现", - * / ? L C #"四个字符，有效范围为1-7的整数或SUN-SAT两个范围。1表示星期天，2表示星期一， 依次类推
     */

    /**
     * 特殊字符含义
     * * : 表示匹配该域的任意值，比如在秒*, 就表示每秒都会触发事件。；
     * ? : 只能用在每月第几天和星期两个域。表示不指定值，当2个子表达式其中之一被指定了值以后，为了避免冲突，需要将另一个子表达式的值设为“?”；
     * - : 表示范围，例如在分域使用5-20，表示从5分到20分钟每分钟触发一次
     * / : 表示起始时间开始触发，然后每隔固定时间触发一次，例如在分域使用5/20,则意味着5分，25分，45分，分别触发一次.
     * , : 表示列出枚举值。例如：在分域使用5,20，则意味着在5和20分时触发一次。
     * L : 表示最后，只能出现在星期和每月第几天域，如果在星期域使用1L,意味着在最后的一个星期日触发。
     * W : 表示有效工作日(周一到周五),只能出现在每月第几日域，系统将在离指定日期的最近的有效工作日触发事件。注意一点，W的最近寻找不会跨过月份
     * LW : 这两个字符可以连用，表示在某个月最后一个工作日，即最后一个星期五。
     * # : 用于确定每个月第几个星期几，只能出现在每月第几天域。例如在1#3，表示某月的第三个星期日。
     */

    /**
     *
     * "0 0 * * * *"          表示每小时0分0秒执行一次
     * "*\/10 * * * * *"      表示每10秒执行一次
     * "0 0 8-10 * * *"       表示每天8，9，10点执行
     * "0 0/30 8-10 * * *"    表示每天8点到10点，每半小时执行
     * "0 0 9-17 * * MON-FRI" 表示每周一至周五，9点到17点的0分0秒执行
     * "0 0 0 25 12 ?"        表示每年圣诞节（12月25日）0时0分0秒执行
     */

    /**
     * 定时任务-线程调用
     */
    @Async("executorCommon")
    @Scheduled(cron="0 0 7 * * ?", fixedDelay=10000)
    public void preDay7Hour() {
        log.info("start executorCommon");
        try {
            System.out.println("当前运行线的程名称：" + Thread.currentThread().getName());
            log.info("今天早上7点or7点十分我执行了一次");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("end executorCommon");
    }
}
