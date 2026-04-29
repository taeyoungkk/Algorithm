import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> ans = new ArrayList<>();

        Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));

        int n = plans.length;
        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            String s = plans[i][1];
            int h = Integer.parseInt(s.substring(0, 2));
            int m = Integer.parseInt(s.substring(3));
            time[i] = h * 60 + m;
        }

        int idx = 0;
        int now = time[0];
        work now_work = null;

        Deque<work> stack = new ArrayDeque<>();

        // 시작 안 한 과제가 있거나, 현재 작업 중이거나, 멈춘 과제가 남아 있으면 계속 진행
        while (idx < n || now_work != null || !stack.isEmpty()) {

            // 1. 지금 시각에 새 과제가 시작하면
            //    진행 중인 과제를 stack에 넣고 새 과제로 교체
            if (idx < n && now == time[idx]) {
                if (now_work != null) {
                    stack.push(now_work);
                }
                now_work = new work(plans[idx][0], Integer.parseInt(plans[idx][2]));
                idx++;
            }

            // 2. 현재 진행 중인 과제가 없으면 stack에서 최근 과제 재개
            if (now_work == null && !stack.isEmpty()) {
                now_work = stack.pop();
            }

            // 3. 현재 과제를 1분 진행
            if (now_work != null) {
                now_work.time--;

                // 끝났으면 정답에 추가
                if (now_work.time == 0) {
                    ans.add(now_work.name);
                    now_work = null;
                }
            }

            now++;
        }

        String[] answer = new String[n];
        int i = 0;
        for (String s : ans) {
            answer[i++] = s;
        }

        return answer;
    }

    class work {
        String name;
        int time;

        work(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }
}