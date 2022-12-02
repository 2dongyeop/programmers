package stackqueue.truck;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(final String... args) {

        final Solution s = new Solution();
        final int[] truckWeights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
        final int result = s.solution(100, 100, truckWeights);

        System.out.println(result);

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int compeleteTime = 0;
        Queue<Truck> waiting_truck = new LinkedList<>();

        for (int w : truck_weights) {
            waiting_truck.add(new Truck(w));
        }

        final Bridge bridge = new Bridge(weight, bridge_length);
        do {
            compeleteTime++;

            bridge.movingTrucks();
            if (!waiting_truck.isEmpty()) {
                if (bridge.isPassingBridge(waiting_truck.peek().getWeight())) {
                    bridge.putTruck(waiting_truck.remove());
                }
            }
        } while (!bridge.isEmpty());

        return compeleteTime;
    }
}

class Truck {
    private final int weight;
    private int remain_distance;

    int getWeight() {
        return weight;
    }

    void setRemain_distance(final int remain_distance) {
        this.remain_distance = remain_distance;
    }

    Truck(final int weight) {
        this.weight = weight;
        this.remain_distance = 0;
    }

    boolean isArrived() {
        return remain_distance == 0;
    }

    void decrease_remain_distance() {
        remain_distance--;
    }
}

class Bridge {
    private int length;
    private int maxWeight;
    private int currentTrucksWeight;
    private Queue<Truck> trucks;

    Bridge(final int length, final int maxWeight) {
        this.trucks = new LinkedList<>();
        this.length = length;
        this.maxWeight = maxWeight;
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

            truck.decrease_remain_distance();
            if (truck.isArrived()) {
                currentTrucksWeight -= truck.getWeight();
                continue;
            }
            trucks.add(truck);
        }
    }

    void putTruck(final Truck truck) {
        truck.setRemain_distance(this.length);

        trucks.add(truck);
        this.currentTrucksWeight += truck.getWeight();
    }
}
