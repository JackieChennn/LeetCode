class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        dir_list = path.split("/")
        for dir in dir_list:
            if dir == '' or dir == '.':
                continue
            elif dir == '..':
                if len(stack) > 0:
                    stack.pop()
            else:
                stack.append(dir)
        result = '/'.join(stack)
        result = '/' + result
        return result