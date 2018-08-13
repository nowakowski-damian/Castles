package com.dnowakowski;

class Castles {

    private enum State {
        UP,
        DOWN
    }

    int countCastles(int[] stretch) {
        int castleCount = 0;

        if(stretch!=null && stretch.length>0) {
            castleCount=1; // 'You can always build a castle at the start of the array, provided it is non-empty'
            int previousAltitude = stretch[0];
            State previousState = null;

            for (int altitude : stretch) {
                State currentState;
                if (altitude > previousAltitude) {
                    currentState = State.UP;
                } else if (altitude < previousAltitude) {
                    currentState = State.DOWN;
                } else continue;

                if (currentState != previousState && previousState!=null) {
                    castleCount++;
                }
                previousState = currentState;
                previousAltitude = altitude;
            }
        }

        return castleCount;
    }
}
