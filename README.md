# Software Studio Assignment 6

## Notes
+ You will have to import the libraries on your own. All the libraries are provided on iLMS.
+ Even you followed the design TA shown in the video, you still have to explain the control of the program in the next section.

## Explanation of the Design
Explain your design in this section.  
Example:
### Operation
+ Clicking on the button "Add All": users can add all the characters into network to be analyzed.
+ Clicking on the button "Clear": users can remove all the characters from network.
+ Hovering on the character: the name of the character will be revealed.
+ By dragging the little circle and drop it in the big circle, the character will be added to the network.
+ By pressing key 1~7 on the keyboard, users can switch between episodes.
+ ...etc.

### Visualization
+ The width of each link is visualized based on the value of the link.
+ ...etc.

這次的作業，是要利用process的設計，完成star wars中1~7集

各個人物之間的關係。我們將每一集的人物都當作一個小圓，一

開始放在畫面的左側，當使用者將由標放到這些小圓上，小圓就

會顯示這個圓代表的人的名字，若點擊小圓，小圓就會移動至右

測的大圓(net)上，每次加入一個小圓，右側的圓就會重新調整位

置(將大圓平分)，若點擊大圓上的小圓，小圓就會回到原處，在右

側大圓上，若兩個人物之間有關連，就會用線將兩個圓連起來，其

中若現越粗，代表關係越深，除了直接點擊，畫面之右上角也設有

兩個button，分別是Add all 及 Clear all，如字面意思，若點擊

Add all可將目前為於左半測之小圓全部加到大圓上，若點擊Clear 

all，可將目前為於右半測大圓上之小圓全數歸回原位。每個畫面

代表一集的人物，若想查看其他集，只需要按鍵盤上任意見即可。