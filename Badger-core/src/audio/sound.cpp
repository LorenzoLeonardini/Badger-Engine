/**
	@author Lorenzo Leonardini
	@version 08/21/2017
*/
#include "sound.h"
#include "sound_manager.h"

namespace badger { namespace audio {

	Sound::Sound(const std::string &name, const std::string &filename)
		: m_Name(name), m_Filename(filename)
	{
		std::vector<std::string> split = split_string(filename, '.');
		if (split.size() < 2)
		{
			std::cout << "[Sound] Invalid file name '" << filename << "'!" << std::endl;
			return;
		}

#ifdef BADGER_EMSCRIPTEN
#else
		m_Sound = gau_load_sound_file(filename.c_str(), split.back().c_str());

		if (!m_Sound)
		{
			std::cout << "[Sound] Could not load file '" << filename << "'!" << std::endl;
			return;
		}
#endif
	}

	Sound::~Sound()
	{
#ifdef BADGER_EMSCRIPTEN
#else
		ga_sound_release(m_Sound);
#endif
	}

	void Sound::play()
	{
#ifdef BADGER_EMSCRIPTEN
#else
		gc_int32 quit = 0;
		m_Handle = gau_create_handle_sound(SoundManager::m_Mixer, m_Sound, &setFlagAndDestroyOnFinish, &quit, NULL);
		m_Handle->sound = this;
		ga_handle_play(m_Handle);
#endif
	}

	void Sound::loop()
	{
#ifdef BADGER_EMSCRIPTEN
#else
		gc_int32 quit = 0;
		m_Handle = gau_create_handle_sound(SoundManager::m_Mixer, m_Sound, &loopOnFinish, &quit, NULL);
		setGain(m_Gain);
		m_Handle->sound = this;
		ga_handle_play(m_Handle);
#endif
	}

	void Sound::resume()
	{
#ifdef BADGER_EMSCRIPTEN
#else
		ga_handle_play(m_Handle);
#endif
	}

	void Sound::pause()
	{
#ifdef BADGER_EMSCRIPTEN
#else
		ga_handle_stop(m_Handle);
#endif
	}

	void Sound::stop()
	{
#ifdef BADGER_EMSCRIPTEN
#else
		if (!isPlaying())
			return;

		ga_handle_stop(m_Handle);
		ga_handle_destroy(m_Handle);
#endif
	}

	void Sound::setGain(float gain)
	{
#ifdef BADGER_EMSCRIPTEN
#else
		if (!m_Handle)
		{
			std::cout << "[Sound] Can't set gain! Sound is not currently playing!" << std::endl;
		}
		m_Gain = gain;
		ga_handle_setParamf(m_Handle, GA_HANDLE_PARAM_GAIN, gain);
#endif
	}

#ifdef BADGER_EMSCRIPTEN
#else
	void setFlagAndDestroyOnFinish(ga_Handle *in_handle, void *in_context)
	{
		Sound *sound = (Sound*)(in_handle->sound);
		sound->stop();
	}

	void loopOnFinish(ga_Handle *in_handle, void *in_context)
	{
		Sound *sound = (Sound*)(in_handle->sound);
		sound->loop();
		ga_handle_destroy(in_handle);
	}
#endif

} }