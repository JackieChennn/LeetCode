class RandomizedSet:

    def __init__(self):
        self.store = []
        self.dict = {}

    def insert(self, val: int) -> bool:
        if val in self.dict:
            return False
        else:
            self.store.append(val)
            self.dict[val] = len(self.store) - 1
            return True

    def remove(self, val: int) -> bool:
        if val in self.dict:
            index = self.dict[val]
            self.store[index]= self.store[len(self.store) - 1]
            self.dict[self.store[len(self.store) - 1]] = index
            self.store.pop()
            self.dict.pop(val)
            return True
        else:
            return False
        

    def getRandom(self) -> int:
        index = random.randrange(len(self.store))
        return self.store[index]
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()