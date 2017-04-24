package study;

/**
 * Created by eguns on 2017. 4. 24..
 */
public class Pet {
    private String petName;
    private String ownerName;

    public Pet(String petName, String ownerName) {
        this.petName = petName;
        this.ownerName = ownerName;
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public static class Builder {
        private String petName;
        private String ownerName;

        public Builder withPetName(String petName) {
            this.petName = petName;
            return this;
        }

        public Builder withOwnerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public Pet build() {
            return new Pet(petName, ownerName);
        }
    }
}
