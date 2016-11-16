package ru.sberbank.school.helloworld.tasks.lesson17_GoodCode.Tractor;

public enum Commands {
    FORWARD {
        @Override
        public void command(Tractor tractor) {
            System.out.println("Move");
            tractor.moveForwards();
        }
    },
    TURN {
        @Override
        public void command(Tractor tractor) {
            System.out.println("Turn");
            tractor.turnClockwise();
        }
    };

    public abstract void command(Tractor tractor);
}