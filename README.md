# InterviewProblemsOrConcepts

Follow programs are there in repo.

1) GetAllEvenNumbersFirst - This program will sort/swap the elements so that all even numbers will be moved to start of array
	Ex:- [1,4,3,10] after our execution it should be [4,10,3,1]
	
2) This class to group the anagrams Using Java8 and also before Java8
	Ex:- "eat" and "tea" are anagrams
	
3) Remove Duplicate Characters in String using Java8 and Before Java8
	EX:- "create eat" output:-"creat"

4) Find the members remaining a room. where input is a list of strings with employeId and RoomEntryIndicator.
		 "<"-- exited out of the room, ">"-- entered in to the room.
	EX:-["1,>","2,>","3,<"] -- in this employee 1 and 2 entered into the room and employee 3 exited the room. 
5) Unique Pair of elements whose difference is equal to given expected number.	

	this is used to find the unique pairs possible when we combined the value with k result in another element of the list.
 	EX:- k value is 1 and the list is  [1, 1, 2, 2, 3, 3]
	 So here sum of first element of list and k produces third element or fourth element of list i.e, 1+1 =2
	 In same way sum of second element of list and k produces third element or fourth element of list i.e, 1+1 =2
	 In same way sum of third element of list and k produces fifth element or sixth element of list i.e, 2+1=3
 	In same way sum of fourth element of list and k produces fifth element or sixth element of list i.e, 2+1=3
 	so here we end up with (1,2), (1,2), (2,3) and (2,3). but we need unique pairs so we should finally have (1,2) 
 	and(2,3) and answer should be 2
6) Pattern and Matcher Examples from java.util.regex package
	From this Examination I found that,"matcher.find" will behave same as "matcher.matches" when find is used with 
	^<<pattern>>$
	if without ^$ find method try to see pattern matches with substring instead of whole string.
	This means if one of the substring matches the pattern then it will treat whole string as matched
7) Singleton Design pattern
	Note:- To Achieve Singleton first rule is to make constructor as private and provide factory method to return static 
	instance.
	1) Eager Initialization
	2) Lazy Initialization -- draw back multiple threaded env singleton will break.
	3) Lazy Initialization with thread safe -- draw back is performance as as instance method it self synchronized. 
	4) Lazy Initialization with thread safe minimize performance issues --Still can break the singleton in case of 
	cloning and Serialization.
	5) Lazy Initialization with thread and clone safe minimize performance issues --Still can break the singleton in case 
	of Serialization.
 8) Multiply given array numbers and return last two digits Using Java 8
 	Note:- Here we have take care of max limit of number like 2 billion (with 9 Zeros and 10 digit Number) in case of 
 	"int" Data Type 9 Quintillion(18 zeros and 19 digit number) in case 
 	of "long" data type.         
 9) Program to demo Thread Dead Lock using two threads.<br>
 	Note 1:- To avoid Dead Lock we have to follow same locking sequence in two threads.	       
 	Note 2:- Default Priority for new Thread is 5 and range for priority is 1-10. If the priority not set in given range 
 		then it will throw Illegal Argument Exception.
 	Note 3:- Thread Run(i.e, t1.run() ) will use main thread to run, start method will create new thread to run.
 		Here is sample output that says main thread when using run method
 			LOCK_ONE t1 lock::main --> This is using t1.run()
			Thread one Synchronized before sleep..
			Thread one Synchronized after sleep..
			LOCK_TWO t2 lock::main --> This is using t2.run()
			Thread two Synchronized before sleep..
			Thread two Synchronized after sleep..
			LOCK_ONE t1 lock::Thread-0 --> This is using t1.start()
			Thread one Synchronized before sleep..
			LOCK_TWO t2 lock::Thread-1 --> This is using t2.start()
			Thread two Synchronized before sleep..
