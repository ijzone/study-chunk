package codingTest.programmers.PCCP.video_player;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/340213#">동영상 재생기</a>
 */
public class Solution {
    static String video_len = "10:55";
    static String pos = "00:05";
    static String op_start = "00:15";
    static String op_end = "06:55";
    static String[] commands = {"prev", "next", "next"};

    public static void main(String[] args) {
        String[] video_len_split = video_len.split(":");
        String[] pos_split = pos.split(":");
        String[] op_start_split = op_start.split(":");
        String[] op_end_split = op_end.split(":");
        int video_len_time = minutesConverter(video_len_split);
        int pos_time = minutesConverter(pos_split);
        int op_start_time = minutesConverter(op_start_split);
        int op_end_time = minutesConverter(op_end_split);

        for (String command : commands) {
            if (pos_time >= op_start_time && pos_time <= op_end_time) {
                pos_time = op_end_time;
            }
            if (command.equals("prev")) {
                // prev 시간 적용 전 현재 재생 시간이 10초 미만인지 확인
                if (pos_time < 10) {
                    pos_time = 0;
                }
                // 오프닝이면 구간 건너뛰기
                if (pos_time >= op_start_time && pos_time <= op_end_time) {
                    pos_time = op_end_time;
                }
                // prev(-10초) 시간 이동
                pos_time -= 10;
                // prev 시간 이동 후에 현재 재생 시간이 10초 미만인지 확인
                if (pos_time < 10) {
                    pos_time = 0;
                }
                // prev 시간 이동 후에 오프닝 구간이면 건너뛰기
                if (pos_time >= op_start_time && pos_time <= op_end_time) {
                    pos_time = op_end_time;
                }
            }else if (command.equals("next")) {
                // next 시간 적용 전 현재 재생 시간이 10초 미만으로 남았는지 확인
                if ((video_len_time - pos_time) < 10) {
                    pos_time = video_len_time;
                }
                // next 시간 적용 전 오프닝이면 구간 건너뛰기
                if (pos_time >= op_start_time && pos_time <= op_end_time) {
                    pos_time = op_end_time;
                }
                // next(+10초) 시간 이동
                pos_time += 10;
                // next 시간 적용 후 오프닝이면 구간 건너뛰기
                if (pos_time >= op_start_time && pos_time <= op_end_time) {
                    pos_time = op_end_time;
                }
                // 재생 시간 이동 후 총 동영상 재생 시간보다 길거나 재생 시간이 10초 미만으로 남았으면 동영상 끝 시간으로 이동
                if (pos_time >= video_len_time || (video_len_time - pos_time) < 10) {
                    pos_time = video_len_time;
                }
            }
        }

        playTimeStringConverter(pos_time);
    }

    private static int minutesConverter(String[] time) {
        int mm = Integer.parseInt(time[0]) * 60;
        int tot = mm + Integer.parseInt(time[1]);

        return tot;
    }

    private static String playTimeStringConverter(int pos_time) {
        System.out.println("pos_time = " + pos_time);
        String mm = String.valueOf((pos_time / 60));
        String ss = String.valueOf((pos_time % 60));

        mm = mm.length() == 1 ? "0" + mm : mm;
        ss = ss.length() == 1 ? "0" + ss : ss;
        String result = mm + ":" + ss;

        System.out.println("Converted Time = " + result);

        return result;
    }
}
