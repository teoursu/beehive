package com.example.dpit.beehive;


    public class Product {
        private String name;
        private String note;
        private int image;


        //Constructor

        public Product( String name, String note, int image ) {
            this.note = note;
            this.name = name;
            this.image= image;

        }

        //Setter, getter


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public int getImage(){return image;}
        public void  setImageResource (int image){this.image=image;}
    }
