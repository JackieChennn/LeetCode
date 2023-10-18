class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        opened = [False] * len(rooms)
        opened[0] = True
        unused_keys = [0]
        while unused_keys:
            next_room = unused_keys.pop()
            for key in rooms[next_room]:
                if not opened[key]:
                    opened[key] = True
                    unused_keys.append(key)
        return all(opened)

