class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int deadline = addTenMinutes(schedules[i]);
            boolean isEligible = true;

            for (int j = 0; j < 7; j++) {
                int dayOfWeek = ((startday - 1 + j) % 7) + 1;

                if (dayOfWeek == 6 || dayOfWeek == 7) {
                    continue;
                }

                if (timelogs[i][j] > deadline) {
                    isEligible = false;
                    break;
                }
            }

            if (isEligible) {
                answer++;
            }
        }

        return answer;
    }

    private int addTenMinutes(int hhmm) {
        int hour = hhmm / 100;
        int minute = hhmm % 100;

        int totalMinutes = hour * 60 + minute + 10;
        int resultHour = totalMinutes / 60;
        int resultMinute = totalMinutes % 60;

        return resultHour * 100 + resultMinute;
    }
}