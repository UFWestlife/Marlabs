package MultiThreadOrder;

public class Order {
    public enum State {
        NEW("NEW"), FULFILLED("FULFILLED");

        public String state;

        private State(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    State state = null;
    Integer id = null;

    public Order(int id) {
        state = State.NEW;
        this.id = id;
    }

    public State getState() {
        return this.state;
    }
}
