package lab11.ex5;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Visitor {
    private boolean rec;
    private Path p;
    long espaco = 0;


    public Visitor(boolean rec, String p) {
        this.rec = rec;
        this.p = Paths.get(p);
    }

    public long total_memory() throws IOException{
        Files.walkFileTree(this.p, new SimpleFileVisitor<Path>(){
            
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
                String[] path = (""+file).split("/");
                String[] root = (""+p).split("/");
                
                String dirname = path[path.length-2];
                String root_name = path[path.length-1];
                
                if (!dirname.equals(root[root.length-1])) {
                    if (rec){
                        root_name = dirname + "/" + root_name;
                    }
                    else
                        return FileVisitResult.CONTINUE;
                }                
                espaco+=attrs.size();
                System.out.println("\t"+root_name + " - " + attrs.size() + " kbytes");
                   
                return FileVisitResult.CONTINUE;

            }

        });

        return espaco;
    }



}
