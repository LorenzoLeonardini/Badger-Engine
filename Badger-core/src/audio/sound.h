#pragma once

#include <string>
#include <iostream>

#include "../utils/stringutils.h"

#ifdef BADGER_EMSCRIPTEN
	#include <emscripten/emscripten.h>
#else
	#include "../../ext/gorilla-audio/gau.h"
	#include "../../ext/gorilla-audio/ga.h"
#endif

namespace badger { namespace audio {

	/**
		Represent a sound in the game.

		Allows to play, pause, stop, loop.

		@author Lorenzo Leonardini
		@version 08/21/2017
	*/
	class Sound
	{
	private:
		std::string m_Name;
		std::string m_Filename;

#ifdef BADGER_EMSCRIPTEN
#else
		ga_Sound *m_Sound;
		ga_Handle *m_Handle;
#endif

		float m_Gain;
	public:
		/**
			Create a sound object

			@param name The name associated with the sound
			@param filename File path
		*/
		Sound(const std::string &name, const std::string &filename);
		~Sound();
		
		void play();
		void loop();
		void resume();
		void pause();
		void stop();

		/**
			Set the volume for the sound
		*/
		void setGain(float gain);

#ifdef BADGER_EMSCRIPTEN
#else
		inline const bool isPlaying() const { return m_Handle ? ga_handle_playing(m_Handle) : false; }
#endif
		inline const float getGain() const { return m_Gain; }
		inline const std::string &getName() const { return m_Name; }
		inline const std::string &getFilename() const { return m_Filename; }

#ifdef BADGER_EMSCRIPTEN
#else
		friend void setFlagAndDestroyOnFinish(ga_Handle *in_handle, void *in_context);
		friend void loopOnFinish(ga_Handle *in_handle, void *in_context);
#endif
	};

} }