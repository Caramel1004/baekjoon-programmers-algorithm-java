import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static class Person {
        int id;
        int weight;
        int height;
        List<Integer> largerPeople;

        Person(int id, int weight, int height) {
            this.id = id;
            this.weight = weight;
            this.height = height;
            this.largerPeople = new ArrayList<>();
        }

        private int getRank() {
            return largerPeople.size() + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        Person[] people = new Person[size];
        for (int id = 0; id < size; id++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people[id] = new Person(id, weight, height);
        }

        for (int id = 0; id < size; id++) {
            for (int opponentId = id + 1; opponentId < size; opponentId++) {
                if (people[id].weight < people[opponentId].weight
                        && people[id].height < people[opponentId].height) {
                    people[id].largerPeople.add(opponentId);
                } else if (people[id].weight > people[opponentId].weight
                        && people[id].height > people[opponentId].height) {
                    people[opponentId].largerPeople.add(id);
                }
            }
        }

        for(Person person : people) {
            sb.append(person.getRank()).append(" ");
        }

        System.out.print(sb.toString().trim());
    }
}
