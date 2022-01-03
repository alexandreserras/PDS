package lab09.ex1;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ListIterator;



public class VectorGeneric<T> {
    private T[] vec;
    private int nElem;
    private final static int ALLOC = 50;
    private int dimVec = ALLOC;
    
    @SuppressWarnings("unchecked")

    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }

    public boolean addElem(T elem) {
        if (elem == null)
            return false;
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }
    
    private void ensureSpace() {
    if (nElem>=dimVec) {
        dimVec += ALLOC;
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[dimVec];
        System.arraycopy(vec, 0, newArray, 0, nElem );
        vec = newArray;
        }
    }

    public boolean removeElem(T elem) {
        for (int i = 0; i < nElem; i++) {
            if (vec[i].equals(elem)) {
                if (nElem-i-1 > 0) // not last element
                System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
                vec[--nElem] = null; // libertar último objecto para o GC
                return true;
                }
            }
        return false;
    }

    public int totalElem() {
        return nElem;
    }
    
    public T getElem(int i) {
        return (T) vec[i];
    }

    public Iterator<T> iterator() {
        return (this).new VectorIterator<T>();
    }

    private class VectorIterator<K> implements Iterator<K>{
        private int indice;

        public VectorIterator(){
            this.indice = 0;
        }


        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return indice<nElem;
        }

        @Override
        public K next() {
            // TODO Auto-generated method stub
            if (hasNext()){
                return (K)VectorGeneric.this.vec[indice++];
            }
            throw new NoSuchElementException("Only " + nElem + " elements");
        }

        public void remove() {
            throw new UnsupportedOperationException("Operação não suportada");
        }
    }






    public ListIterator<T> listIterator() {
        return new VectorListIterator<T>();
    }

    public ListIterator<T> listIterator(int index) {
        return new VectorListIterator<T>(index);
    }

    private class VectorListIterator<T> implements ListIterator<T> {

        private int indice;
        public VectorListIterator() {
            this.indice=0;
        }

        public VectorListIterator(int indice) {
            this.indice=indice;
        }



        @Override
        public void add(T e) { 
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Operação não suportada");
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return indice<nElem;
        }

        @Override
        public boolean hasPrevious() {
            // TODO Auto-generated method stub
            return this.indice>0;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            if (hasNext())
                return (T) VectorGeneric.this.vec[this.indice++];
            throw new NoSuchElementException("Index out of bounds!");
        }

        @Override
        public int nextIndex() {
            // TODO Auto-generated method stub
            if (hasNext())
                return this.indice+1;
            return -1;
        }

        @Override
        public T previous() {
            // TODO Auto-generated method stub
            if (hasPrevious())
                return (T) VectorGeneric.this.vec[this.indice--];
            throw new NoSuchElementException("Index out of bounds!");
            
        }

        @Override
        public int previousIndex() {
            // TODO Auto-generated method stub
            if (hasPrevious())
                return this.indice-1;
            return -1;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Operação não suportada");
        }

        @Override
        public void set(T e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Operação não suportada");
        }

    }

}