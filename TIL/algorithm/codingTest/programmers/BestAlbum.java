package codingTest.programmers;

import java.util.*;

/**
 * 베스트앨범
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
 * 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 * @restrictions
 * 1. genres[i]는 고유번호가 i인 노래의 장르입니다.
 * 2. plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * 3. genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 4. 장르 종류는 100개 미만입니다.
 * 5. 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 6. 모든 장르는 재생된 횟수가 다릅니다.
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42579">베스트앨범</a>
 */
public class BestAlbum {

    public static String[] genres = {"classic", "pop", "classic", "classic", "pop", "classic"};
    public static int[] plays = {500, 600, 150, 800, 2500, 100};
//    public static String[] genres = {"pop", "rock", "classic", "ballad", "pop", "ballad", "ballad", "ballad", "pop", "pop", "classic", "classic"};
//    public static int[] plays = {100, 300, 400, 150, 100, 300, 200, 600, 700, 110, 900, 9000};

    public static void main(String[] args) {
        albumList(genres, plays);
    }

    static int[] albumList(String[] g, int[] p) {
        System.out.println("장르: " + Arrays.toString(g));
        System.out.println("플레이: " + Arrays.toString(p));

        if ((g.length >= 1 && g.length <= 10000) && (p.length >= 1 && p.length <= 10000)) {
            // 장르 별 총 플레이 합계 맵 & 플레이 리스트
            Map<String, Integer> genreHm = new HashMap<>();
            List<Song> playList = new ArrayList<>();
            for (int i = 0; i < g.length; i++) {
            System.out.printf("Genre: %s / Plays: %d\n", genres[i], plays[i]);
                genreHm.put(g[i], genreHm.getOrDefault(g[i], 0) + p[i]);
                playList.add(new Song(i, g[i], p[i]));
            }
            System.out.println("장르 수: " + genreHm.size());
            if(genreHm.size() > 99) {
                int[] result = {0};
                return result;
            }

            // 많이 플레이된 장르순으로 정렬
            Object[] sortedGenre = genreHm.entrySet().toArray();
            Arrays.sort(sortedGenre, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    return ((Map.Entry<String, Integer>) o2).getValue().compareTo(((Map.Entry<String, Integer>) o1).getValue());
                }
            });

            System.out.println("장르 별 총 플레이 합계: " + genreHm.entrySet());
            System.out.println("============================");

            Comparator<Song> comparator = new Comparator<Song>() {
                @Override
                public int compare(Song o1, Song o2) {
//                    System.out.println("compare: " + (o2.getPlayCount() - o1.getPlayCount()));
//                    System.out.println(o1.getPlayCount() + " / " + o2.getPlayCount());
                    if((o2.getPlayCount() - o1.getPlayCount()) == 0) {
                        return 1;
                    }
                    return o2.getPlayCount() - o1.getPlayCount();
                }
            };

            int songCount = 0;
            List<Integer> orderedList = new ArrayList<>();
            List<Song> ordered = new ArrayList<>();
            for (Object obj : sortedGenre) {
                for (Song song : playList) {
                    System.out.printf("genre: %s / idx: %d / count: %d\n", song.getGenre(), song.getIdx(), song.getPlayCount());
                    if (((Map.Entry)obj).getKey().equals(song.getGenre())) {
                        ordered.add(song);
                        songCount++;
                    }
                }

                System.out.println("ordered size: " + ordered.size());
                Collections.sort(ordered, comparator);

                for (int i = 0; i < ordered.size(); i++) {
                    if(i < 2) {
                        orderedList.add(ordered.get(i).getIdx());
                    }
                }

                System.out.printf("장르(%s) 별 ordered: %s\n", ((Map.Entry)obj).getKey(), ordered);
                ordered.clear();
                songCount = 0;
            }
            int[] result = orderedList.stream().mapToInt(i -> i).toArray();
            System.out.println("[result]: " + Arrays.toString(result));
            return result;
        }

        int[] result = {0};
        return result;
    }

    static class Song {
        private int idx;
        private String genre;
        private int playCount;

        public Song(int idx, String genre, int playCount) {
            this.idx = idx;
            this.genre = genre;
            this.playCount = playCount;
        }

        public int getIdx() {
            return idx;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlayCount() {
            return playCount;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "idx=" + idx +
                    ", genre='" + genre + '\'' +
                    ", playCount=" + playCount +
                    '}';
        }
    }
}
