class ParkingSystem {
    int[] freq;
    public ParkingSystem(int big, int medium, int small) {
        freq = new int[3];
        freq[0] = big;
        freq[1] = medium;
        freq[2] = small;
    }
    public boolean addCar(int carType) {
        if(freq[carType-1] == 0) return false;
        freq[carType-1]--;
        return true;
    }
}




// class ParkingSystem {
//     int b, m, s;
//     public ParkingSystem(int big, int medium, int small) {
//         b = big;
//         m = medium;
//         s = small;
//     }
//     public boolean addCar(int carType) {
//         if(carType == 1){
//             // b--;
//             // return b >= 0;
//             return --b >= 0;
//         }
//         else if(carType == 2){
//             // m--;
//             // return m >= 0;
//             return --m >= 0;
//         }
//         else {
//             // s--;
//             // return s >= 0;
//             return --s >= 0;
//         }
//     }
// }
