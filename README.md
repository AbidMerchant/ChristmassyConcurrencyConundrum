# Java Simulation of a Christmassy Concurrency Conundrum

UCan’t plc operates a Christmas theme park “100% Lapland Style!” in a muddy field that used to
be a roundabout on the outskirts of Preston. Here, University students are employed at minimum
wage during the holidays to dress up as Elves and Santas, disappointing crowds of cold and
bored children by eventually handing out tacky gifts from various make-shift Grottos. All the while,
miserable looking reindeer nibble on the artificial snow in their paddocks beside the lengthy
queues for the disgusting portable toilets. The park is organised so that after paying the hefty
entrance fee, children join a queue for a specific Grotto according to their age – the theory being
that they will receive an age-appropriate gift from one of several Santas.
A disappointed family and other visitors describe their visit to a similar theme park here and here.
Unfortunately, UCan’t is facing financial difficulty since the City Council (under pressure from local
consumer groups) have discontinued a substantial tax break for the company this year. A new
manager, Dr. Kris Krampus, has been brought into effect cost savings. Dr. Krampus has 
2
convinced the directors that by automating the sorting of gifts into sacks in the central “workshop”
(a crudely disguised former abattoir building) using his own patented machine, the services of
several student Elves could be dispensed with!
Up until now, Elves have carried armfuls of carefully chosen gifts from the Workshop to the various
Grottos for distribution by one of the Santas. In the new system, at the start of their shift, Elves
will fill giant hoppers with randomly selected gifts. The hopper will feed the gifts at a predetermined rate onto a conveyor belt leading into the Sorting machine. The Sorting machine
directs each gift along a sequence of conveyor belts and turntables, to be deposited in the
appropriate sack. When the machine has finished or the sacks are full, elves can deliver them in
a trolley to the appropriate grotto.
The ‘elf and safety union’ insist that a maximum number of gifts can be safely loaded into a sack
for an Elf to pick up at any one time, dependent on the Elf’s age and general fitness. The capacity
of each sack must therefore be clearly labelled in such a way that the machine knows how many
presents it can put into it.
Once started by the elf in charge, the machine will run for a set length of time. If the machine is
no longer able to direct presents into sacks because they are full, it will pause until either the timer
has run out, or an elf changes the full sack for an empty one.
Your task is to develop a simple Java simulation of the workings of the patent ‘PresentSorting Machine’, using Concurrency.
Specification of Dr Krampus’ Patent Present-Sorting Mach
