# WarFake
Создать прототип игры на языке Java. При выполнении задания пользоваться системами контроля версий (GitHub, Bitbucket…).

В игре создается отряд определенной расы, состоящий из одного мага, трех лучников и четырех бойцов.

Предусмотрено четыре расы: эльфы, люди, орки, нежить. Эльфы и люди играют против орков и нежити.

В начале игры случайным образом создаются два враждующих отряда той или иной расы. 

Все персонажи отряда делятся на две группы: обычные и привилегированные (с улучшенными показателями). Персонаж при наложении на него улучшения перемещается в привилегированную группу.

Порядок ходов для рас определяется случайным образом. За один ход все персонажи отряда могут выполнить действие (определяется случайным образом): сначала из привилегированной группы, а если она пуста, тогда из общего списка персонажей отряда рандомно. Персонаж из привилегированной группы после выполнения одного действия перемещается в общую группу.

Возможности персонажей:
1)	Раса эльфов:
a)	маг: 
i)	лечить (+20%, но не более 100 HP)
ii)	улучшение умений участников команды (точность для лучников +10%, сила урона для воинов +20%)
b)	лучник:
i)	стрелять из лука (нанесение урона 15 HP при попадании 100%)
ii)	атаковать (нанесение урона 2 HP)
c)	воин:
i)	атаковать мечом (нанесение урона 20 HP при попадании 100%)
2)	Раса людей:
a)	маг: 
i)	улучшение умений участников команды (точность для арбалетчиков +10%, сила урона для воинов +20%)
ii)	атаковать магией (нанесение урона 20 HP при попадании 100%)
b)	арбалетчик:
i)	стрелять из арбалета (нанесение урона 15 HP при попадании 100%)
ii)	атаковать (нанесение урона 5 HP)
c)	воин:
i)	атаковать мечом (нанесение урона 20 HP при попадании 100%)
3)	Раса орков:
a)	шаман:
i)	улучшение умений участников команды (точность для лучников +10%, сила урона для гоблинов +20%)
ii)	наложение проклятия (снятие улучшений с персонажей противника для следующего хода)
b)	лучник:
i)	стрелять из лука (урон 17 HP при попадании 100%)
ii)	атаковать (нанесение урона 2 HP)
c)	гоблин:
i)	атака дубиной (нанесение урона 10 HP при попадании 100%)
4)	Раса нежити:
a)	некромант:
i)	превратить в зомби (превращение случайного умершего воина любой расы в зомби, превращенный воин получает 80 HP и сила его урона уменьшается на 20% от первоначального значения)
ii)	атака (нанесение урона 5 HP)
b)	лучник:
i)	стрелять из лука (нанесение урона 15 HP при попадании 100%)
ii)	атаковать (нанесение урона 2 HP)
c)	зомби:
i)	действия, которые были доступны персонажу до превращения, с учетом уменьшения силы урона

При ударе с точностью 100% урон составляет 100% от максимума, при уменьшении % попадания уменьшается наносимый урон.
С начала игры каждый персонаж имеет уровень жизни равный 100 HP.

Выводить ход игры в консоль: вести статистику ходов с порядком ходов (кто, кого, нанесенный урон, умер). По завершении игры сохранять лог в файл.
