#include <iostream>
#include <vector>

using namespace std;
vector<int> xoa(int n, vector<int> as) {
    vector<int> list;
    int count = 0;
    bool check[as.size()];
    for (int i = 0; i < as.size(); i++) {
        check[i] = true;
    }
    int i = 1;
    while (count + 1 < as.size() && i <= n) {
        check[count + 1] = false;
        i++;
        count += i + 1;
    }
    for (int i = 0; i < as.size(); i++) {
        if (check[i]) list.push_back(as[i]);
    }
    return list;
}

int main() {
    int n;
    cout << "Nhap n: ";
    cin >> n;
    vector<int> as;
    
    int size;
    cout << "Nhap size of list: ";
    cin>>size;
    cout << "Nhap danh sach as: ";
    for (int i = 0; i < size; i++) {
        int value;
        cin >> value;
        as.push_back(value);
    }
    
    vector<int> list = xoa(n, as);
    
    for (int i = 0; i < list.size(); i++) {
        cout << list[i] << " ";
    }
    
    return 0;
}
