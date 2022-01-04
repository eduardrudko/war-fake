# WarFake

A simple console type application prototype of self-playable game between Middle-Earth races

To run:

`cd ./war-fake/src`

`javac -cp . $(find . -name "*.java")` inside root directory

`java warfake.war.game.Game`



The game creates a squad of a certain race, consisting of one magician, three archers and four fighters.

There are four races: elves, humans, orcs, undead. Elves and humans play against orcs and undead.

At the beginning of the game, two warring squads of a particular race are randomly created.

All characters in the squad are divided into two groups: ordinary and privileged (with improved performance). A character, when an improvement is applied to him, moves to a privileged group.

The order of moves for races is determined randomly. In one move, all the characters of the squad can perform an action (determined randomly): first from the privileged group, and if it is empty, then randomly from the general list of characters in the squad. A character from a privileged group, after performing one action, is moved to the general group.

Character abilities:
1) Race of elves:
a) magician:
i) heal (+ 20%, but not more than 100 HP)
ii) improving the skills of team members (accuracy for archers + 10%, damage power for warriors + 20%)
b) archer:
i) shoot a bow (dealing 15 HP damage on 100% hit)
ii) attack (dealing 2 HP damage)
c) warrior:
i) attack with a sword (dealing damage 20 HP on hit 100%)
2) Race of people:
a) magician:
i) improving the skills of team members (accuracy for crossbowmen + 10%, damage power for warriors + 20%)
ii) attack with magic (dealing damage 20 HP on hit 100%)
b) crossbowman:
i) shoot a crossbow (dealing 15 HP damage on 100% hit)
ii) attack (dealing damage 5 HP)
c) warrior:
i) attack with a sword (dealing damage 20 HP on hit 100%)
3) Orc Race:
a) shaman:
i) improving the skills of team members (accuracy for archers + 10%, damage power for goblins + 20%)
ii) imposing a curse (removing improvements from enemy characters for the next turn)
b) archer:
i) shoot from a bow (damage 17 HP on hit 100%)
ii) attack (dealing 2 HP damage)
c) goblin:
i) attack with a club (dealing 10 HP damage on hit of 100%)
4) Race of Undead:
a) necromancer:
i) turn into a zombie (turning a random deceased warrior of any race into a zombie, the turned warrior gets 80 HP and the power of his damage is reduced by 20% of the original value)
ii) attack (dealing damage 5 HP)
b) archer:
i) shoot a bow (dealing 15 HP damage on 100% hit)
ii) attack (dealing 2 HP damage)
c) zombies:
i) the actions that were available to the character before the transformation, taking into account the reduction in damage power

When hit with 100% accuracy, the damage is 100% of the maximum, with a decrease in the% hit, the damage done decreases.
From the beginning of the game, each character has a life level of 100 HP.
