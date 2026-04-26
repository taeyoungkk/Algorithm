import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 수 저장
        // 예: "pop" -> 3100
        Map<String, Integer> totalPlayMap = new HashMap<>();

        // 장르별 노래 목록 저장
        // 예: "pop" -> [Song(0, 500), Song(2, 600)]
        Map<String, List<Song>> songMap = new HashMap<>();

        // 1. 장르별 총 재생 수와 장르별 노래 목록 만들기
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 장르별 총 재생 수 누적
            totalPlayMap.put(genre, totalPlayMap.getOrDefault(genre, 0) + play);

            // 아직 해당 장르의 리스트가 없으면 새로 생성
            if (!songMap.containsKey(genre)) {
                songMap.put(genre, new ArrayList<>());
            }

            // 해당 장르 리스트에 현재 노래 추가
            songMap.get(genre).add(new Song(i, play));
        }

        // 2. 장르를 총 재생 수 기준으로 내림차순 정렬
        List<String> genreList = new ArrayList<>(totalPlayMap.keySet());
        genreList.sort((a, b) -> Integer.compare(totalPlayMap.get(b), totalPlayMap.get(a)));

        // 결과를 저장할 리스트
        List<Integer> result = new ArrayList<>();

        // 3. 정렬된 장르 순서대로 노래를 최대 2개씩 뽑기
        for (String genre : genreList) {
            List<Song> songs = songMap.get(genre);

            // 장르 내 노래 정렬
            // 1) 재생 수 내림차순
            // 2) 재생 수가 같으면 고유번호 오름차순
            songs.sort((a, b) -> {
                if (a.play != b.play) {
                    return Integer.compare(b.play, a.play);
                }
                return Integer.compare(a.index, b.index);
            });

            // 최대 2곡만 결과에 추가
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i).index);
            }
        }

        // 4. List<Integer>를 int[]로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    // 노래 정보를 저장할 클래스
    static class Song {
        int index; // 고유번호
        int play;  // 재생 수

        Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
}