import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayDays = toDays(today);

        Map<String, Integer> map = new HashMap<>();

        for (String term : terms) {
            String[] tmp = term.split(" ");
            map.put(tmp[0], Integer.parseInt(tmp[1]) * 28);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");

            int startDays = toDays(tmp[0]);
            int expireDays = startDays + map.get(tmp[1]) - 1;

            if (expireDays < todayDays) {
                ans.add(i + 1);
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

    private int toDays(String date) {
        String[] s = date.split("\\.");
        int y = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);

        return y * 12 * 28 + m * 28 + d;
    }
}