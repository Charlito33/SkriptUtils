#SkriptUtils

SkriptUtils is a Minecraft Skript Addon witch add some features.

###Current Version : 0.2.0
  - ####Tests : ❓ (Not done)
  - ####Changes log :
    - Added players tags are changed condition
    - Changed some little things

###Features :
- Hide / Show players tags
- Change players tags*

**ProtocolLib is needed*

###Syntax :

- ####Effects :

  - #####Hide Tags :
    - ``hide [the] %players%['s] (tag|name)[s]``
    - ``hide [the] (tag|name)[s] of %players%``

  - #####Show Tags :
    - ``show [the] %players%['s] (tag|name)[s]``
    - ``show [the] (tag|name)[s] of %players%``
  
  - #####Change Player's tag :
    - ``set [the] (tag|name)[s] of %players% to %string%``
    - ``set [the] %players%['s] (tag|name)[s] to %string%``
  
  - #####Reset Player's tag :
    - ``reset [the] (tag|name)[s] of %players%``
    - ``reset [the] %players%['s] (tag|name)[s]``
    
- ####Conditions :
  
  - ####Players tags are visible :
    - ``[the] %players%['s] (tag|name)[s] (is|are) visible[s]``
    - ``[the] (tag|name)[s] of %players% (is|are) visible[s]``
    
  - ####Players tags are hidden :
    - ``[the] %players%['s] (tag|name)[s] (is|are) hidden[s]``
    - ``[the] (tag|name)[s] of %players% (is|are) hidden[s]``
    
  - ####Players tags are changed :
    - ``[the] %players%['s] (tag|name)[s] (is|are) changed``
    - ``[the] (tag|name)[s] of %players% (is|are) changed``
    
- ####Expressions :

  - #####Player's tag :
    - ``[the] %player%['s] (tag|name)``
    - ``[the] (tag|name) of %player%``


###Dependencies :
- ProtocolLib *(For change players tags)*
- NameTagChanger *(Included --> Don't need to Install)*

