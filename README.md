# EditTextBottomLineChanger
An easy way to change edit text bottom line color dynamically

![simpleedittextchange](https://cloud.githubusercontent.com/assets/14084447/22911155/44ec7256-f299-11e6-8262-d1efac17cb64.gif)
--------------------------------------------------------------------------------------------
first of all , in your project gradle
add this -
-------------------------------------------------------------------------------------------
		allprojects {
		repositories {
			..
			maven { url 'https://jitpack.io' }
		}
	}
-------------------------------------------------------------------------------------------
	
then go to your app's dependencies
add this -
-------------------------------------------------------------
	      compile 'com.github.IamStY:EditTextBottomLineChanger:v1.0'
-------------------------------------------------------------------------------------------

* Note : after every settings to SimpleEditText , don't forget to call  SimpleEditText.notifyUiChanges() to refresh the current UI




For initialization
-----------------------------------------------------------------------------------
  SimpleEditText simpleEditTextChange =(SimpleEditText)this.findViewById(R.id.simple_et);
   --------------------------------------------------------------------------------

   and xml 
------------------------------------------------------------------------------
 
 
				 <com.example.stevenyang.easyedittextcolorchanging.SimpleEditText
					android:layout_width="match_parent"
					android:layout_height="wrap_content"
					android:id="@+id/simple_et"/>
		
--------------------------------------------------------------------------------
To set the focused and unfocused stroke color
-------------------------------------------------------------------------------
	simpleEditTextChange.setFocusedEditTextLineColor(Color.BLACK);
	simpleEditTextChange.setUnfocusedEditTextLineColor(Color.GRAY);
	
    ------------------------------------------------------------------------------
To set the focused and unfocused stroke size
-------------------------------------------------------------------------------
	simpleEditTextChange.setFocusedStrokeSize(1);
	simpleEditTextChange.setUnfocusedStrokeSize(1);
	
    ------------------------------------------------------------------------------
To set the focused and unfocused stroke size
-------------------------------------------------------------------------------
	simpleEditTextChange.setFocusedTextPaddingBottom(25);
	simpleEditTextChange.setUnfocusedTextPaddingBottom(25);
	
    ------------------------------------------------------------------------------

	Finally , Call the below function to refresh the UI change
	
	simpleEditTextChange.notifyUiChanges();
	
	
		
---------------------------------------------------------------------------------





Peace!
                             Yang Cheng-Kuang