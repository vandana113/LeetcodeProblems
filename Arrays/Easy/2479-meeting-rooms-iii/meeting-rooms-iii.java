class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int [] rooms = new int[n];
        Arrays.sort(meetings, new Comparator<> () {
            public int compare(int[] meeting1, int [] meeting2) {
                return Integer.compare(meeting1[0], meeting2[0]);
            }
        });

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();

        PriorityQueue<Pair<int[],Integer>> occupiedRooms = new PriorityQueue<>(new Comparator<>() {
            public int compare(Pair<int[],Integer> meeting1, Pair<int[],Integer> meeting2) {
                if(meeting1.getKey()[1] == meeting2.getKey()[1]){
                    return meeting1.getValue() - meeting2.getValue();
                }
                return meeting1.getKey()[1] - meeting2.getKey()[1];
            }
        });

        for(int i=0; i<n; i++) {
            freeRooms.add(i);
        }


        for(int i=0; i<meetings.length; i++) {
            while(!occupiedRooms.isEmpty() && occupiedRooms.peek().getKey()[1] <= meetings[i][0]) {
                int roomNumber = occupiedRooms.peek().getValue();
                occupiedRooms.remove();
                freeRooms.add(roomNumber);
            }
            if(!freeRooms.isEmpty()) {
                int roomNumber = freeRooms.remove();
                rooms[roomNumber]++;
                occupiedRooms.add(new Pair<>(new int[] {0, meetings[i][1]}, roomNumber));
            } else {
                // No room empty, delay the current meeting
                Pair<int[],Integer> endedMeeting = occupiedRooms.remove();
                int endTime = endedMeeting.getKey()[1] + (meetings[i][1] - meetings[i][0]); 
                int roomNumber = endedMeeting.getValue();
                
                int [] newMeetingTime = new int[]{0, endTime};
                occupiedRooms.add(new Pair<>(newMeetingTime, roomNumber));
                rooms[roomNumber]++;
            }
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
}