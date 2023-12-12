# Git Command
## Rebase
### 최초 커밋 author 수정
```git
git rebase -i --root
```
vim 에디터가 열리면 `pick -> edit` 수정
```git
git commit --amend --author="authorName <email@gmail.com>"
```
다음 커밋 재설정으로 이동
```git
git rebase --continue
```
커밋 변경사항 적용되었는지 확인
```git
git log
```
### HEAD 기준 이전 커밋 수정
```git
git rebase [-i | --interactive] HEAD~<?번째 커밋>
ex) git rebase -i HEAD~3
```
#### 바로 직전 커밋 내용 수정
```git
git commit --amend
```