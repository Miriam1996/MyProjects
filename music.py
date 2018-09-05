from tkinter import *
import os
import random
import pyglet
import mp3play,time
import glob

index = 0
songs = []
isplay = False
isshuffle = False
indir = "C:\\Users\\Miriam Schnoll\\OneDrive\\music"
for root, dirs, filenames in os.walk(indir):
    for f in filenames:
        songs.append(f)
os.chdir(indir)
print(os.getcwd())
songs = sorted(songs)
root = Tk()
currentSong = Label(root, text="")
path=indir +"\\"+songs[index]
#music=pyglet.resource.media(str('Austin Plaine - Hard Days.mp3'),streaming=FALSE)
#music.play()
i=0

#time.sleep(20)
#clip.stop()
#random.shuffle(songs)
data= songs[index]
clip = mp3play.load(data)
#clip.play()

def play():
    global i
    global clip
    #os.startfile(songs[index])
    data= songs[index]
    clip = mp3play.load(data)
    clip.play()
    currentSong.config(text=songs[index])

def cplay():
    global i
    global clip
    play()
    if i%2==0 and i!=0:
       clip.stop()
    i+=1

play()

def prev():
    global index
    index -= 1
    play()


def next():
    global index
    index += 1
    play()


# function to turn shuffle on and off
def shuffle():
    global songs
    global isshuffle
    global index
    if (isshuffle):
        songs = sorted(songs)
        isshuffle = False
        shuffleBtn.config(text="Shuffle: off")
        index = 0
        currentSong.config(text=songs[index])
    else:
        random.shuffle(songs)
        isshuffle = True
        shuffleBtn.config(text="Shuffle: on")
        index = 0
        currentSong.config(text=songs[index])


root.title = "music player"
playBtn = Button(root, text="play", command=cplay)
prevBtn = Button(root, text="prev", command=prev)
nextBtn = Button(root, text="next", command=next)
shuffleBtn = Button(root, text="Shuffle: off", command=shuffle)
prevBtn.pack(side=LEFT)
playBtn.pack(side=LEFT)
nextBtn.pack(side=LEFT)
shuffleBtn.pack(side=LEFT)
currentSong.pack(side=BOTTOM)

root = mainloop()


