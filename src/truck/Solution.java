package truck;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int compeleteTime = 0;
        Queue<Truck> waiting_truck = new LinkedList<>();

        for (int w : truck_weights) {
            waiting_truck.add(new Truck(w));
        }

        final Bridge b = new Bridge(weight, bridge_length);
        do {
            compeleteTime++;

            b.movingTrucks();
            if (!waiting_truck.isEmpty()) {
                if (b.isPassingBridge(waiting_truck.peek().getWeight())) {
                    b.putTruck(waiting_truck.remove());
                }
            }
        } while (!b.isEmpty());

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
    private Queue<Truck> bridge;

    Bridge(final int length, final int maxWeight) {
        this.bridge = new LinkedList<>();
        this.length = length;
        this.maxWeight = maxWeight;
        this.currentTrucksWeight = 0;
    }

    boolean isEmpty() {
        return bridge.isEmpty();
    }

    boolean isPassingBridge(final int truckWeight) {
        final int estimateWeight = currentTrucksWeight + truckWeight;

        return estimateWeight <= maxWeight;
    }

    void movingTrucks() {
        for (int truckPosition = 0; truckPosition < bridge.size(); truckPosition++) {
            final Truck truck = bridge.remove();

            truck.decrease_remain_distance();
            if (truck.isArrived()) {
                currentTrucksWeight -= truck.getWeight();
                continue;
            }
            bridge.add(truck);
        }
    }

    void putTruck(final Truck truck) {
        truck.setRemain_distance(this.length);

        bridge.add(truck);
        this.currentTrucksWeight += truck.getWeight();
    }
}
