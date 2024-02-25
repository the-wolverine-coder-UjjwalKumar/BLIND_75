package algorithm;

public class DisjointSetUnion {

    public static void main(String[] args) {
        // we have given pairs
        // make union(a, b) -> merge a,b in one set
        // find(a,b) -> return weather a,b is in same set.
        // sol 1: here we can make the adjacency list for each node and
        // so disjoint set return this in constant time

        // union by rank (with path compression)
        // union by size

        int n = 7;
        DisjointSetUnion.DU disJointSet = new DU(n);
        // unionByRank
//        disJointSet.unionByRank(1,2);
//        disJointSet.unionByRank(2,3);
//        disJointSet.unionByRank(4,5);
//        disJointSet.unionByRank(6,7);
//        disJointSet.unionByRank(5,6);

        // unionBySize
        disJointSet.unionBySize(1,2);
        disJointSet.unionBySize(2,3);
        disJointSet.unionBySize(4,5);
        disJointSet.unionBySize(6,7);
        disJointSet.unionBySize(5,6);
        boolean inSameSet = disJointSet.inSameSet(1,2);
        System.out.println(inSameSet);

        inSameSet = disJointSet.inSameSet(1,4);
        System.out.println(inSameSet);


        disJointSet.unionBySize(3,7);
//        disJointSet.unionByRank(3,7);

        inSameSet = disJointSet.inSameSet(1,4);
        System.out.println(inSameSet);

    }

    static class DU {
        int[] parent;
        int[] rank;
        int[] size;

        public DU(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            size = new int[n+1];

            // initialize parent
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                rank[i] = 0;
                size[i]= 1;
            }
        }

        // without path compression
        public int findParent(int u) {
            int ultimateParentU = parent[u];
            if (ultimateParentU == u) return u;
            return findParent(ultimateParentU);
        }

        // with path compression
        public int findP(int u) {
            int ultimateParentU = parent[u];
            if (ultimateParentU == u) return u;
            parent[u] = findP(ultimateParentU);
            return parent[u];
        }

        public void unionByRank(int u, int v) {
            int ultimateParentU = findP(u);
            int ultimateParentV = findP(v);

            if (ultimateParentU == ultimateParentV) return;

            if (rank[ultimateParentU] > rank[ultimateParentV]) {
                parent[ultimateParentV] = ultimateParentU;
            } else if (rank[ultimateParentV] > rank[ultimateParentU]){
                parent[ultimateParentU] = ultimateParentV;
            } else {
                parent[ultimateParentV] = ultimateParentU;
                rank[ultimateParentU]++;
            }
        }

        // NOTE : use any one at a time both having TC as 4alpha
        public void unionBySize(int u, int v) {
            int ultimateParentU = findP(u);
            int ultimateParentV = findP(v);

            if (ultimateParentU == ultimateParentV) return;

            if (size[ultimateParentU] > size[ultimateParentV]) {
                parent[ultimateParentV] = ultimateParentU;
                size[ultimateParentU] += size[ultimateParentV];
            } else if (rank[ultimateParentV] > rank[ultimateParentU]){
                parent[ultimateParentU] = ultimateParentV;
                size[ultimateParentV] += size[ultimateParentU];
            } else {
                parent[ultimateParentV] = ultimateParentU;
                size[ultimateParentU] += size[ultimateParentV];
            }
        }

        public boolean inSameSet(int u, int v) {
            return findP(u) == findP(v);
        }
     }
}
