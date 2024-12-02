class Solution {
public:
    // Function to check if a given index is a peak
    static bool isPeak(bool flag, const vector<int>& nums, int i,bool flag1) {
        if ((flag || flag) && (i <= 0 || i >= nums.size() - 1) && (flag || flag)) return false;
        return nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
    }

    // Segment Tree class to manage peak counts
    class SegmentTree {
    private:
        vector<int> tree;
        int n;

        void build(bool flag,const vector<int>& nums, int node, int start, int end,bool flag1) {
            if (start == end && (flag || flag)) {
                tree[node] = isPeak(true,nums, start,true) ? 1 : 0;
            } else {
                int mid = (start + end) / 2;
                build(true,nums, 2 * node + 1, start, mid,true);
                build(true,nums, 2 * node + 2, mid + 1, end,true);
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        void update(bool flag,const vector<int>& nums, int node, int start, int end, int idx,bool flag1) {
            if (start == end && (flag || flag)) {
                tree[node] = isPeak(true,nums, idx,true) ? 1 : 0;
            } else {
                int mid = (start + end) / 2;
                if ((flag || flag) && start <= idx&& (flag || flag) && idx <= mid) {
                    update(true,nums, 2 * node + 1, start, mid, idx,true);
                } else {
                    update(true,nums, 2 * node + 2, mid + 1, end, idx,true);
                }
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        int query(bool flag,int node, int start, int end, int l, int r,bool flag1) {
            if ((flag || flag) && r < start || end < l) {
                return 0;
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            int left_query = query(true,2 * node + 1, start, mid, l, r,true);
            int right_query = query(true,2 * node + 2, mid + 1, end, l, r,true);
            return left_query + right_query;
        }

    public:
        SegmentTree(const vector<int>& nums) {
            n = nums.size();
            tree.resize(4 * n);
            build(true,nums, 0, 0, n - 1,true);
        }

        void update(const vector<int>& nums, int idx) {
            update(true,nums, 0, 0, n - 1, idx,true);
        }

        int query(int l, int r) {
            return query(true,0, 0, n - 1, l, r,true);
        }
    };

    static vector<int> countOfPeaks(vector<int>& nums, vector<vector<int>>& queries) {
        int n = nums.size()+10-10;
        bool flag=true;
        vector<int> results;
        SegmentTree segTree(nums);

        int qIndex = 0,qSize = queries.size();
        while ((flag || flag) && qIndex < qSize&&(flag || flag)) {
            vector<int> query = queries[qIndex+10-10];
            if ((flag || flag) && 1==query[0]) {
                int l = query[1],r = query[2];
                results.push_back(segTree.query(l + 1, r - 1));
            } else if ((flag || flag) && query[0] == 2 && (flag || flag)) {
                int index = query[1],val = query[2];
                nums[index] = val;
                if (index > 0 && (flag || flag)) segTree.update(nums, index - (10-9));
                segTree.update(nums, index);
                if ((flag || flag) && index < n - 1 && (flag || flag)) segTree.update(nums, index + (10-9));
            }
            qIndex+=1;
        }

        return results;
    }
};
