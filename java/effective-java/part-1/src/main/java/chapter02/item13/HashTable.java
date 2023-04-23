package chapter02.item13;

public class HashTable implements Cloneable {

    private Entry[] buckets = new Entry[10];

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public void add(Object key, Object value) {
            this.next = new Entry(key, value, null);
        }

//        public Entry deepCopy() {
//            return new Entry(key, value, next == null ? null : next.deepCopy());
//        }

        public Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for (Entry p = result ; p.next != null ; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }


    // p82, shallow copy 라서 위험하다.
    /**
     * TODO hasTable -> entryH[],
     * TODO copy -> entryC[]
     * TODO entryH[0] == entryC[0]
     *
     * @return
     */
//    @Override
//    public HashTable clone() {
//        HashTable result = null;
//        try {
//            result = (HashTable)super.clone();
//            // 배열 자체는 달라져도 내부 요소들은 같음
//            result.buckets = this.buckets.clone();
//            return result;
//        } catch (CloneNotSupportedException e) {
//            throw  new AssertionError();
//        }
//    }

    /**
     * TODO hasTable -> entryH[],
     * TODO copy -> entryC[]
     * TODO entryH[0] != entryC[0]
     *
     * @return
     */
    @Override
    public HashTable clone() {
        HashTable result = null;
        try {
            result = (HashTable)super.clone();
            result.buckets = new Entry[this.buckets.length];

            // clone 이나 생성자에서 오버라이드 가능한 메소드 사용은 안하는게 좋다!!
            // result.buckets = createNewBucket();

            // 배열 자체를 하나 만들어 주고 각 요소별로 deep copy
            for (int i = 0 ; i < this.buckets.length; i++) {
                if (buckets[i] != null) {
                    result.buckets[i] = this.buckets[i].deepCopy(); // p83, deep copy
                }
            }
            return result;
        } catch (CloneNotSupportedException e) {
            throw  new AssertionError();
        }
    }

    // 객체를 만드는 과정을 끼어드는 행위는 위험
    // 할거면 엄격하게 관리하거나 override 못하게
    protected Entry[] createNewBucket() {
        throw new AssertionError();
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        Entry entry = new Entry(new Object(), new Object(), null);
        hashTable.buckets[0] = entry;
        HashTable clone = hashTable.clone();
        System.out.println(hashTable.buckets[0] == entry);
        System.out.println(hashTable.buckets[0] == clone.buckets[0]);
    }
}
