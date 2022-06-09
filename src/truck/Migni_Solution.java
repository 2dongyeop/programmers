package truck;

import java.util.LinkedList;
import java.util.Queue;

//code by @mgstyle97
//참고하려고 가져온 코드입니다.
//민기형이 풀이한 다리를 지나는 트럭 Solution
public class Migni_Solution {

    public static void main(final String... args) {

        final Migni_Solution s = new Migni_Solution();
        final int[] truckWeights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
        final int result = s.solution(100, 100, truckWeights);

        System.out.println(result);

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int completionTime = 0;

        final Queue<Truck> waitingTrucks = new LinkedList<>();

        for (final int truckWeight : truck_weights) {
            waitingTrucks.add(new Truck(truckWeight));
        }

        final Bridge bridge = new Bridge(weight, bridge_length);
        do {
            completionTime++;

            bridge.movingTrucks();

            if (!waitingTrucks.isEmpty()) {

                if (bridge.isPassingBridge(waitingTrucks.peek().getWeight())) {
                    bridge.putTruck(waitingTrucks.remove());
                }
            }


        } while (!bridge.isEmpty());

        return completionTime;
    }

}

class Truck {

    private final int weight;

    private int remainingDistance;

    Truck(final int weight) {
        this.weight = weight;
        this.remainingDistance = 0;
    }

    void setRemainingDistance(final int remainingDistance) {
        this.remainingDistance = remainingDistance;
    }

    int getWeight() {
        return weight;
    }

    boolean isArrived() {
        return remainingDistance == 0;
    }

    void decreaseRemainingDistance() {
        remainingDistance--;
    }

}

class Bridge {

    private final Queue<Truck> trucks;
    private final int maxWeight;
    private final int bridgeLength;

    private int currentTrucksWeight;

    Bridge(
            final int maxWeight,
            final int bridgeLength
    ) {
        this.trucks = new LinkedList<>();
        this.maxWeight = maxWeight;
        this.bridgeLength = bridgeLength;
        this.currentTrucksWeight = 0;
    }

    boolean isEmpty() {
        return trucks.isEmpty();
    }

    boolean isPassingBridge(final int truckWeight) {
        final int estimateWeight = currentTrucksWeight + truckWeight;

        return estimateWeight <= maxWeight;
    }

    void movingTrucks() {

        final int currentTruckCount = trucks.size();
        for (int truckPosition = 0; truckPosition < currentTruckCount; truckPosition++) {
            final Truck truck = trucks.remove();

            truck.decreaseRemainingDistance();
            if (truck.isArrived()) {
                currentTrucksWeight -= truck.getWeight();
                continue;
            }
            trucks.add(truck);
        }

    }

    void putTruck(final Truck truck) {
        truck.setRemainingDistance(this.bridgeLength);

        trucks.add(truck);
        this.currentTrucksWeight += truck.getWeight();
    }

}
