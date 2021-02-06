/**
 * Name: RallyDemo
 * This class is for selecting which initData we want to execute.
 * It starts the simulation managing the competition.
 *
 * @version 1.0 (12/24/2020) 06/02/21
 * @author Raul Hormigo Ceron and Eduardo Cano Garcia
 */
public class RallyDemo {
    public static void main(String[] args) {
//        CompleteChampionship completeChampionship = new CompleteChampionship();
        EarlyEndingData earlyEndingData = new EarlyEndingData();
//        NoWinnerData noWinnerData = new NoWinnerData();

        Organization.getInstance().manageChampionship();
    }
}
