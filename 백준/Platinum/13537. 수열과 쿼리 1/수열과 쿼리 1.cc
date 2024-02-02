#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pii = pair<int, int>;
using pli = pair<long, int>;
using pplipii = pair<pli, pii>;


int N, M;
ll A[400000], ans[100000];
pli order[100000]; //val, pos
pplipii query[100000]; // (val, queryIndex), range

void update(int position, int low = 1, int high = N, int index = 1) {
    if (high < position || position < low) return;
    A[index] += 1;
    if (low == high) return;

    int mid = (low + high) / 2;
    update(position, low, mid, index * 2);
    update(position, mid + 1, high, index * 2 + 1);
}

ll getSumOf(pii range, int low = 1, int high = N, int index = 1) {
    if (high < range.first || range.second < low) return 0;
    if (range.first <= low && high <= range.second) return A[index];

    int mid = (low + high) / 2;
    return getSumOf(range, low, mid, index * 2)
        + getSumOf(range, mid + 1, high, index * 2 + 1);
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> order[i].first;
        order[i].second = i + 1;
    }
    sort(order, order + N, greater<pli>());

    cin >> M;
    for (int i = 0; i < M; i++) {
        cin >> query[i].second.first
            >> query[i].second.second
            >> query[i].first.first;
        query[i].first.second = i;
    }
    sort(query, query + M, greater<pplipii>());

    int j = 0;
    for (int i = 0; i < M; i++) {
        while (j!=N && query[i].first.first < order[j].first){
            update(order[j].second);
            j++;
        }

        ans[query[i].first.second] = getSumOf( pii(query[i].second.first, query[i].second.second) );
    }

    for (int i = 0; i < M; i++) {
        cout << ans[i] << '\n';
    }
    
    return 0;
}