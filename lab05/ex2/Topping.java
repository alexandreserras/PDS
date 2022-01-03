package ex2;
public enum Topping {
    FRUIT("Fruit"),CHOCOLATE("Chocolate"),LEITE_COCO("Leite de côco");
    private String custom;

        private Topping(String custom) {
            this.custom = custom;
        }

        public String getCustomString() {
            return custom;
        }




}
