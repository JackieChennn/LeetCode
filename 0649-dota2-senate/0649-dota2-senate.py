class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        arr = list(senate)
        r_count = arr.count('R')
        d_count = len(arr) - r_count

        def ban(to_ban: str, startAt: int) -> bool:
            loop_around = False
            pointer = startAt
            while True:
                if pointer == 0:
                    loop_around = True
                if arr[pointer] == to_ban:
                    arr.pop(pointer)
                    break
                pointer = (pointer + 1) % len(arr)
            return loop_around
        
        turn = 0
        while r_count > 0 and d_count > 0:
            if arr[turn] == 'R':
                banned_senator_before = ban('D', (turn + 1) % len(arr))
                d_count -= 1
            else:
                banned_senator_before = ban('R', (turn + 1) % len(arr))
                r_count -= 1
            if banned_senator_before:
                turn -= 1
            turn = (turn + 1) % len(arr)
        return 'Radiant' if d_count == 0 else 'Dire'