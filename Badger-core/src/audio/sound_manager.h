#pragma once

#include <vector>

#include "sound.h"

#define GAU_THREAD_POLICY_MULTI 2
#include "../../ext/gorilla-audio/gau.h"
#include "../../ext/gorilla-audio/ga.h"

namespace badger { namespace audio {

	/**
		Manages all the sounds in the engine

		@author Lorenzo Leonardini
		@version 08/21/2017
	*/
	class SoundManager
	{
	private:
		friend class Sound;

		static gau_Manager *m_Manager;
		static ga_Mixer *m_Mixer;

		static std::vector<Sound*> m_Sounds;
	public:
		/**
			Initialize the sound manager
		*/
		static void init();
		/**
			Store a Sound in the manager
		*/
		static void add(Sound *sound);
		/**
			Get a Sound stored in the manager

			@param name the name associated with the Sound
			@return the Sound object
		*/
		static Sound* get(const std::string &name);
		/**
			Method called by the engine every frame to continue playing the sounds
		*/
		static void update();
		static void clean();
	private:
		SoundManager() {}
	};

} }