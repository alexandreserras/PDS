package ex2;
public enum Cream {
    WHIPPED_CREAM("Whipped"),RED_BERRIES("Red_Berries"),VANILLA("Vanilla"),LARANJA("Laranja");
    
    private String custom;

        private Cream(String custom) {
            this.custom = custom;
        }

        public String getCustomString() {
            return custom;
        }

}
