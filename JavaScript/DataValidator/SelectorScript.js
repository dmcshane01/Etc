// Daniel DelyMcShane
// 6/21/2016
/*Validates user input and disables checkboxes to prevent submission of incorrect data*/


<script type="text/javascript">
			
				//global array of question elements
				var question_1 = document.getElementsByName("Answer_1");
				var question_2 = document.getElementsByName("Answer_2");
				var question_3 = document.getElementsByName("Answer_3");
				var question_4 = document.getElementsByName("Answer_4");
		
			/* 
				Everytime the user clicks anywhere in the HIT the script runs.
			*/
			window.onclick = function()
			{
				checkSelections(); //calls the main function in the script on click
			}
			
			function checkSelections(){
		
				//set all flags to false so that they are reset each time the user clicks if buttons are changed
				var indoorsFlag = false; //if true we disable question 4
				var manmadeFlag = false; //if true disable question 4
				var naturalFlag = false; //if true we disable question 3
				//Thhis function doesn't check if 3 and 4 are unanswered
				
				/*==========Check that inputs for Question 1 are valid, display an alert and fix if input is invalid======  */
				
				if(question_1[0].checked == true) //Selected as indoors
				{
					if(question_1[1].checked == true) //if users tries to select outdoors after selecting indoors
					{
						//uncheck both checkboxes
						question_1[0].checked = false; 
						question_1[1].checked = false; 
						alert("You can't select both indoors and outdoors"); //tell them no
					}
					else{
						indoorsFlag = true;
					}
					
					
				}//end of first if
				else if(question_1[1].checked == true) //Selected as outdoors
				{
					if(question_1[0].checked == true) //if users tries to select indoors after selecting outdoors
					{
						//uncheck both checkboxes
						question_1[0].checked = false; 
						question_1[1].checked = false; 
						alert("You can't select both indoors and outdoors"); //tell them no
					}
				}//end of else if
				
				/*==========Check that inputs for Question 2 are valid, display an alert and fix if input is invalid======  */
				
				if(question_2[0].checked == true) //Selected as man-made
				{
					if(question_2[1].checked == true) //if users tries to select natural after selecting man-made
					{
						//uncheck both checkboxes
						question_2[0].checked = false; 
						question_2[1].checked = false; 
						alert("You can't select both man-made and natural"); //tell them no
					}
					else{
						manmadeFlag = true;
					}
					
				}//end of first if
				else if(question_2[1].checked == true) //Selected as natural
				{
					if(question_2[0].checked == true) //if users tries to select manmade after selecting natural
					{
						//uncheck both checkboxes
						question_2[0].checked = false; 
						question_2[1].checked = false; 
						alert("You can't select both man-made and natural"); //tell them no
					}
					else{
						naturalFlag = true;
					}
				}//end of else if 
				
				//Now check for which flags have been activated and call the disabled function
				if(indoorsFlag)
				{
					disableQ4();
				}
				else if(manmadeFlag)
				{
					disableQ4();
				}
				else if(naturalFlag)
				{
					disableQ3();
				}
			}
			
			//disables Q4 and enables Q3(if it was previously disabled)
			function disableQ4()
			{
				//disables all checkboxes and unchecks them
				for(var i = 0; i < question_4.length; i++)
				{
					question_4[i].checked = false;
					question_4[i].disabled = true;
				}
				
				//enables Q3 if previously disabled
				for(var i = 0; i < question_3.length; i++)
				{
					question_3[i].checked = false;
					question_3[i].disabled = false;
				}
	
			}
			
			
			//disables Q3 and enables Q4(if it was previously disabled)
			function disableQ3()
			{
				//disables all checkboxes and unchecks them
				for(var i = 0; i < question_3.length; i++)
				{
					question_3[i].checked = false;
					question_3[i].disabled = true;
				}
				
				//enables Q4 if previously disabled
				for(var i = 0; i < question_4.length; i++)
				{
					question_4[i].checked = false;
					question_4[i].disabled = false;
				}
			}
		</script>