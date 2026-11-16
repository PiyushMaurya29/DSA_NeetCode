class ParkingSystem {
    int b, m, s;
    public ParkingSystem(int big, int medium, int small) {
        b = big;
        m = medium;
        s = small;
    }
    public boolean addCar(int carType) {
        if(carType == 1){
            b--;
            return b >= 0;
        }
        else if(carType == 2){
            m--;
            return m >= 0;
        }
        else {
            s--;
            return s >= 0;
        }
    }
}
