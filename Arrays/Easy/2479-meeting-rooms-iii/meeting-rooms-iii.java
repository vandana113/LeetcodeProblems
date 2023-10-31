class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int [] rooms = new int[n];
        Arrays.sort(meetings, new Comparator<> () {
            public int compare(int[] meeting1, int [] meeting2) {
                return Integer.compare(meeting1[0], meeting2[0]);
            }
        });

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        
        // end Time and room number
        PriorityQueue<int []> occupiedRooms = new PriorityQueue<>(new OccupiedComparator());

        for(int i=0; i<n; i++) {
            freeRooms.add(i);
        }


        for(int i=0; i<meetings.length; i++) {
            while(!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= meetings[i][0]) {
                int roomNumber = occupiedRooms.peek()[1];
                occupiedRooms.remove();
                freeRooms.add(roomNumber);
            }
            int endTime = meetings[i][1];
            if(freeRooms.isEmpty()) {
                // No room empty, delay the current meeting
                endTime = occupiedRooms.peek()[0] + (meetings[i][1] - meetings[i][0]);
                int roomNumber = occupiedRooms.peek()[1];
                occupiedRooms.remove();
                freeRooms.add(roomNumber);
            }
            int roomNumber = freeRooms.remove();
            occupiedRooms.add(new int[] {endTime, roomNumber});
            rooms[roomNumber]++;
        }

        int maxMeetings = 0;
        int roomNumber = 0;
        for(int i=0; i<n; i++) {
            if(rooms[i] > maxMeetings) {
                maxMeetings = rooms[i];
                roomNumber = i;
            }
        }

        return roomNumber;
    }

    public class OccupiedComparator implements Comparator<int []> {
        public int compare(int [] meeting1, int [] meeting2) {
            if(meeting1[0] == meeting2[0]) {
                return meeting1[1] - meeting2[1];
            }
            return meeting1[0] - meeting2[0];
        }
    }
}