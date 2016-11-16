package ru.sberbank.school.helloworld.tasks.lesson17_GoodCode.Tractor;

public enum Orientation {

    NORTH {
        @Override
        public void moveForwards(Tractor tractor) {
            tractor.yIncrement();
        }

        @Override
        public void turnClockwise(Tractor tractor) {
            tractor.setOrientation(Orientation.EAST);
        }
    },
    EAST {
        @Override
        public void moveForwards(Tractor tractor) {
            tractor.xIncrement();
        }

        @Override
        public void turnClockwise(Tractor tractor) {
            tractor.setOrientation(Orientation.SOUTH);
        }
    },
    SOUTH {
        @Override
        public void moveForwards(Tractor tractor) {
            tractor.yDecrement();
        }

        @Override
        public void turnClockwise(Tractor tractor) {
            tractor.setOrientation(Orientation.WEST);
        }
    },
    WEST {
        @Override
        public void moveForwards(Tractor tractor) {
            tractor.xDecrement();
        }

        @Override
        public void turnClockwise(Tractor tractor) {
            tractor.setOrientation(Orientation.NORTH);
        }
    };

    public abstract void moveForwards(Tractor tractor);

    public abstract void turnClockwise(Tractor tractor);

}