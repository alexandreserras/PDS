package ex2;

import java.util.List;


public class Movie {
    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    public static class Builder{
        
        //mandatory
        private final String title;

        //optional
        private int yearMovie=0;
        private Person direMovie=null;
        private Person writerMovie=null;
        private String sMovie="";
        private List<Person> castMovie;
        private List<Place> locaMovie;
        private List<String> lanMovie;
        private List<String> gMovie;
        private boolean isTMovie=false;
        private boolean isNetfliMovie=false;
        private boolean isIndMovie=false;
        
        
        
        
        public Builder(String title){
            this.title=title;
        }
        
        public Builder yearMovie(int year){
            yearMovie=year;
            return this;
        }

        public Builder direMovie(Person director){
            direMovie = director;
            return this;
        }

        public Builder writerMovie(Person writer){
            writerMovie = writer;
            return this;
        }

        public Builder sMovie(String series){
            sMovie=series;
            return this;
        }

        public Builder isTMovie(boolean isTelevision){
            isTMovie=isTelevision;
            return this;
        }

        public Builder isNetfliMovie(boolean isNetflix){
            isNetfliMovie=isNetflix;
            return this;
        }

        public Builder isIndMovie(boolean isIndependent){
            isIndMovie=isIndependent;
            return this;
        }

        //Métodos com Listas
        public Builder castMovie(Person cast){
            castMovie.add(cast);
            return this;
        }
        
        public Builder locaMovie(Place locations){
            locaMovie.add(locations);
            return this;
        }

        public Builder lanMovie(String languages){
            lanMovie.add(languages);
            return this;
        }

        public Builder gMovie(String genre){
            gMovie.add(genre);
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }

    }

    private Movie(Builder builder){
        title = builder.title;
        year = builder.yearMovie;
        director = builder.direMovie;
        writer = builder.writerMovie;
        series = builder.sMovie;
        cast = builder.castMovie;
        locations=builder.locaMovie;
        languages=builder.lanMovie;
        genres=builder.gMovie;
        isTelevision= builder.isTMovie;
        isNetflix = builder.isNetfliMovie;
        isIndependent=builder.isIndMovie;
    }


}
