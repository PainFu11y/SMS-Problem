"SMS" Task

The problem is to find the number of possible original messages that could have been transformed into the given SMS message on an old mobile phone. The phone uses buttons with letters, where each button has multiple letters. To enter a specific letter, you need to press the button a certain number of times, and pauses are required between letters on the same button.

The phone may randomly insert or ignore pauses, which leads to various combinations for the same original message. The goal is to find how many possible original messages could be transformed into the given SMS message if it were typed on this device.

Solution Algorithm:

1.Break the received message into parts corresponding to the letters on each button.

2.Apply possible combinations for each part, considering that after each letter on the same button, a pause may be inserted.

3.Calculate the number of possible original messages that could result in the given message.


The input contains the length of the original message and the received message. The output should contain the number of possible original messages.